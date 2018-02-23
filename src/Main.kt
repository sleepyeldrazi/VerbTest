import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

import kotlin.collections.HashMap

val numOfRows = 15
var numberOfVerbs = 0

//support functions for random and checking if verb is in an array
fun rand(from: Int, to: Int): Int = Random().nextInt(to - from) + from
fun notIn(item: Verb, allVerbs: Array<Verb?>): Boolean = (0 until allVerbs.size).none { item == allVerbs[it] }

//keep reference of all the text fields
var allTextFields: HashMap<Int, TextField> = HashMap()

//add a row of three text inputs for the 3 forms of the verbs
fun addRow(chosen: Int, first: String, second: String, third: String, frame: JFrame) {
    val verbFrame = JPanel(GridLayout(1, 3, 10, 5))
    verbFrame.preferredSize = Dimension(500, 20)

    allTextFields[numberOfVerbs] = TextField(first)
    allTextFields[numberOfVerbs+1] = TextField(second)
    allTextFields[numberOfVerbs+2] = TextField(third)

    when (chosen) {
        1 -> {
            allTextFields[numberOfVerbs]?.isEditable = false}
        2 -> {
            allTextFields[numberOfVerbs+1]?.isEditable = false}
        else -> {
            allTextFields[numberOfVerbs+2]?.isEditable = false}
    }
    verbFrame.add(allTextFields[numberOfVerbs])
    verbFrame.add(allTextFields[numberOfVerbs+1])
    verbFrame.add(allTextFields[numberOfVerbs+2])
    numberOfVerbs+=3
    frame.add(verbFrame)
}

class VerbClass: ActionListener {

    //setup the windows with buttons
    private val mainFrame = JFrame("Verb Test")

    private val checkButton = JButton("Check")
    private val resetButton = JButton("Reset") // will implement later

    init {
        mainFrame.layout = FlowLayout()

        setVerbs()
        resetButton.addActionListener(this)
        checkButton.addActionListener(this)
        mainFrame.add(checkButton)
        //mainFrame.add(resetButton)

        mainFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        mainFrame.setSize(540, numOfRows * 30 + 50)
        mainFrame.isVisible = true
    }

    // setup the textboxes with verbs
    private val verbs = VerbInit()
    private var usedVerbs = arrayOfNulls<Verb>(numOfRows)
    private var markVerb: HashMap<Int, String> = HashMap() // row , default

    private fun setVerbs() {
        for (i: Int in 0..(numOfRows - 1)) {
            var currentVerb: Verb = verbs.getVerb()
            while (!notIn(currentVerb, usedVerbs)) {
                currentVerb = verbs.getVerb()
            }
            usedVerbs[i] = currentVerb
            val pickedForm = rand(1, 4)
            when (pickedForm) {
                1 -> {
                    markVerb[i] = currentVerb.pres
                    addRow(pickedForm, currentVerb.pres, "", "", mainFrame)}
                2 -> {
                    markVerb[i] = currentVerb.pret
                    addRow(pickedForm, "", currentVerb.pret, "", mainFrame)}
                else -> {
                    markVerb[i] = currentVerb.part2
                    addRow(pickedForm, "", "", currentVerb.part2, mainFrame)}
            }
        }
    }

    override fun actionPerformed(e: ActionEvent) {
        if(e.source == resetButton){
            VerbClass()
        }
        else if (e.source == checkButton){
            for(i in 0..(numOfRows - 1)){
                verbs.checkVerb(allTextFields[i*3], allTextFields[i*3 + 1], allTextFields[i*3 + 2], markVerb[i])
            }
            val mistakesFrame = JFrame ("Mistakes")
            mistakesFrame.layout = GridLayout(verbs.mistakes.size,1)
            mistakesFrame.setSize(500, verbs.mistakes.size * 30)
            for (i in 0..(verbs.mistakes.size - 1)){
                mistakesFrame.add(Label("   The right answer was: ${verbs.mistakes[i].pres}     ${verbs.mistakes[i].pret}     ${verbs.mistakes[i].part2}", Label.LEFT))
            }
            mistakesFrame.isVisible = true
        }
    }
}

    fun main(args: Array<String>) {
        VerbClass()
    }