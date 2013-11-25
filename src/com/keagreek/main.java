package com.keagreek;

import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

/**
 * Created with IntelliJ IDEA.
 * User: link
 * Date: 11/25/13
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */



public class main extends JPanel
        implements ActionListener  {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton openFileButton;
    static private final String newline = "\n";
    JTextArea log;
    JFileChooser fc = new JFileChooser();

    public main() {

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openFileButton = new JButton("Open a File...",
                createImageIcon("/images/Open16.gif"));
        openFileButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
//        saveButton = new JButton("Save a File...",
//                createImageIcon("images/Save16.gif"));
//        saveButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
//        JPanel buttonPanel = new JPanel(); //use FlowLayout
//        buttonPanel.add(openButton);
//        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
//        add(buttonPanel, BorderLayout.PAGE_START);
//        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openFileButton) {
            int returnVal = fc.showOpenDialog(main.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new main());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

    public void setData(main data) {
    }

    public void getData(main data) {
    }

    public boolean isModified(main data) {
        return false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}