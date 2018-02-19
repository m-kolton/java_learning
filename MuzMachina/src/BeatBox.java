import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList; //checkboxy przechowywane w ArrayList
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame frame;
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
			"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas",
			"Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
			"High Agogo", "Open Hi Conga"}; //nazwy instrumentów przechowywane w tablicy
	
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63}; //numery instrumentów reprezentuj¹ce faktyczne nuty
	
	//metoda main
	public static void main(String[] args) {
		new BeatBox().buildGUI(); //tworzenie obiektu i wywo³anie metody buildGUI
	}
	
	//metoda przygotowuj¹ca interfejs u¿ytkownika
	public void buildGUI() {
		frame = new JFrame("BeatBox maker"); //tworzenie ramki
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //domyœlna operacja zamkniêcia
		BorderLayout layout = new BorderLayout(); //menad¿er layoutu
		JPanel background = new JPanel(layout); //zmiana menad¿era uk³adu panelu z FlowLayout na BorderLayout
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //przestrzeñ miêdzy panelem a komponentami
		
		checkboxList = new ArrayList<JCheckBox>(); //nowa ArrayLista komponentów checkbox
		Box buttonBox = new Box(BoxLayout.Y_AXIS); //box na przyciski
		
		JButton start = new JButton("Start"); //nowy przycisk start
		start.addActionListener(new MyStartListener()); //dodanie obs³ugi zdarzeñ przycisku
		buttonBox.add(start); //dodanie przycisku do boxu przycisków
		
		JButton stop = new JButton("Stop"); //nowy przycisk stop
		stop.addActionListener(new MyStopListener()); //dodanie obs³ugi zdarzeñ przycisku
		buttonBox.add(stop); //dodanie przycisku do boxu przycisków
		
		JButton tempoUp = new JButton("TempoUp"); //nowy przycisk tempoup
		tempoUp.addActionListener(new MyTempoUpListener()); //dodanie obs³ugi zdarzeñ przycisku
		buttonBox.add(tempoUp); //dodanie przycisku do boxu przycisków
		
		JButton tempoDown = new JButton("TempoDown"); //nowy przycisk tempodown
		start.addActionListener(new MyTempoDownListener()); //dodanie obs³ugi zdarzeñ przycisku
		buttonBox.add(tempoDown); //dodanie przycisku do boxu przycisków
		
		Box nameBox = new Box(BoxLayout.Y_AXIS); //nowy box na nazwy instrumentów
		for(int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i])); //dodanie nazw instrumentów do boxa
		}
		
		background.add(BorderLayout.EAST, buttonBox); //dodanie do panelu boxa z przyciskami
		background.add(BorderLayout.WEST, nameBox); //dodanie do panelu boxa z nazwami instrumentów
		
		frame.getContentPane().add(background); //dodanie panelu do ramki
		
		GridLayout grid = new GridLayout(16, 16); //tworzenie tabeli 16x16
		grid.setVgap(1); //przerwy pionowe miêdzy kolumnami
		grid.setHgap(2); //przerwy poziome miêdzy wierszami
		mainPanel = new JPanel(grid); //nowy panel którego zawartoœci¹ jest tabela
		background.add(BorderLayout.CENTER, mainPanel); //dodanie panela do œrodkowego obszaru panelu t³a
		
		for(int i = 0; i < 256; i++) {
			JCheckBox checkbox = new JCheckBox(); 
			checkbox.setSelected(false); //odznaczenie wszystkich checkboxów
			checkboxList.add(checkbox); //dodanie checkboxów do ArrayList checkboxów
			mainPanel.add(checkbox);
		}
		
		setUpMidi(); //wywo³anie metody setUpMidi
		
		frame.setBounds(50, 50, 300, 300);
		frame.pack();
		frame.setVisible(true);		
	}
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer(); //uzyskanie sekwensera
			sequencer.open(); //otworzenie sekwensera
			sequence = new Sequence(Sequence.PPQ, 4); //utworzenie sekwencji
			track = sequence.createTrack(); //utworzenie œcie¿ki
			sequencer.setTempoInBPM(120); //ustalenie tempa na 120 BMP
		} catch (Exception e) { //przechwycenie wyj¹tku
			e.printStackTrace();
		}
	}
	
	public void buildTrackAndStart() {
		int[] trackList = null; 
		
		sequence.deleteTrack(track);
		track = sequence.createTrack();
	
		for(int i = 0; i < 16; i++) {
			trackList = new int[16];
			
			int key = instruments[i];
			
			for(int j = 0; j < 16; j++) {
				
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
				if(jc.isSelected()) {
				trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}
			
			makeTrack(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		}
		
		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class MyStartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
		}
	}
	
	class MyStopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			sequencer.stop();
		}
	}
	
	class MyTempoUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	}
	
	class MyTempoDownListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 0.97));
		}
	}
	
	public void makeTrack(int[] list) {
		for(int i = 0; i < 16; i++) {
			int key = list[i];
			
			if(key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
