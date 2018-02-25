import java.awt.Color
import java.awt.TextField

data class Verb(val pres: String, val pret: String, val part2: String, var used: Boolean = false)

class VerbInit{

    var mistakes: MutableList<Verb> = mutableListOf<Verb>()

    private val verbs: Array<Verb> = arrayOf(
            Verb("befehlen", "befahl", "hat befohlen"),
            Verb("beginnen","begann","hat begonnen"),
            Verb("beißen","biss","hat gebissen"),
            Verb("betrügen","betrog","hat betrogen"),
            Verb("beweisen","bewies","hat bewiesen"),
            Verb("bewerben","bewarb","hat beworben"),
            Verb("biegen","bog","hat/ist gebogen"),
            Verb("bieten","bot","hat geboten"),
            Verb("verbieten","verbot","hat verboten"),
            Verb("binden","band","hat gebunden"),
            Verb("verbinden","verband","hat verbunden"),
            Verb("bitten","bat","hat gebeten"),
            Verb("bleiben","blieb","ist geblieben"),
            Verb("braten","briet","hat gebraten"),
            Verb("brechen","brach","hat gebrochen"),
            Verb("unterbrechen","unterbrach","hat unterbrochen"),
            Verb("brennen","brannte","hat gebrannt"),
            Verb("verbrennen","verbrannte","hat verbrannt"),
            Verb("denken","dachte","hat gedacht"),
            Verb("empfehlen","empfahl","hat empfohlen"),
            Verb("entscheiden","entschied","hat entschieden"),
            Verb("erschrecken","erschrak","ist erschrocken"),
            Verb("essen","aß","hat gegessen"),
            Verb("fahren","fuhr","hat/ist gefahren"),
            Verb("erfahren","erfuhr","hat erfahren"),
            Verb("überfahren","überfuhr","hat überfahren"),
            Verb("fallen","fiel","ist gefallen"),
            Verb("gefallen","gefiel","hat gefallen"),
            Verb("fangen","fing","hat gefangen"),
            Verb("anfangen","fing an","hat angefangen"), // page 1
            Verb("finden","fand","hat gefunden"),
            Verb("erfinden","erfand","hat erfunden"),
            Verb("fliegen","flog","hat/ist geflogen"),
            Verb("fliehen","floh","ist geflohen"),
            Verb("fließen","floss","ist geflossen"),
            Verb("fressen","fraß","hat gefressen"),
            Verb("frieren","fror","hat/ist gefroren"),
            Verb("erfrieren","erfror","ist erfroren"),
            Verb("geben","gab","hat gegeben"),
            Verb("gehen","ging","ist gegangen"),
            Verb("gelingen","gelang","ist gelungen"),
            Verb("gelten","galt","hat gegolten"),
            Verb("genießen","genoss","hat gegossen"),
            Verb("geschehen","geschah","ist geschehen"),
            Verb("gewinnen","gewann","hat gewonnen"),
            Verb("gießen","goss","hat gegossen"),
            Verb("gleichen","glich","hat geglichen"),
            Verb("vergleichen","verglich","hat verglichen"),
            Verb("graben","grub","hat gegraben"),
            Verb("greifen","griff","hat gegriffen"),
            Verb("halten","hielt","hat gehalten"),
            Verb("behalten","behielt","hat behalten"),
            Verb("erhalten","erhielt","hat erhalten"),
            Verb("unterhalten","unterhielt","hat unterhalten"),
            Verb("verhalten","verhielt","hat verhalten"),
            Verb("hängen","hing","hat gehangen"),
            Verb("heben","hob","hat gehoben"),
            Verb("heißen","hieß","hat geheißen"),
            Verb("helfen","half","hat geholfen"),
            Verb("kennen","kannte","hat gekannt"),
            Verb("erkennen","erkannte","hat erkannt"),
            Verb("kommen","kam","ist gekommen"),
            Verb("bekommen","bekam","hat bekommen"), //page 2
            Verb("laden", "lud", "hat geladen"),
            Verb("einladen","lud ein","hat eingeladen"),
            Verb("lassen","ließ","hat gelassen"),
            Verb("entlassen","entließ","hat entlassen"),
            Verb("verlassen","verließ","hat verlassen"),
            Verb("laufen","lief","ist gelaufen"),
            Verb("leiden","litt","hat gelitten"),
            Verb("leihen","lieh","hat geliehen"),
            Verb("lesen","las","hat gelesen"),
            Verb("liegen","lag","hat gelegen"),
            Verb("lügen","log","hat gelogen"),
            Verb("meiden","mied","hat gemieden"),
            Verb("messen","maß","hat gemessen"),
            Verb("nehmen","nahm","hat genommen"),
            Verb("nennen","nannte","hat genannt"),
            Verb("ernennen","ernannte","hat ernannt"),
            Verb("raten","riet","hat geraten"),
            Verb("beraten","beriet","hat beraten"),
            Verb("erraten","erriet","hat erraten"),
            Verb("geraten","geriet","ist geraten"),
            Verb("reißen","riss","hat gerissen"),
            Verb("zerreißen","zerriss","hat zerrissen"),
            Verb("reiten","ritt","hat/ist geritten"),
            Verb("rennen","rannte","ist gerannt"),
            Verb("riechen","roch","hat gerochen"),
            Verb("rufen","rief","hat gerufen"),
            Verb("schaffen","schuf","hat geschaffen"),
            Verb("scheinen","schien","hat gescheinen"),
            Verb("schieben","schob","hat geschoben"),
            Verb("schießen","schoss","hat geschossen"),
            Verb("schlafen","schlief","hat geshchlafen"),
            Verb("schlagen","schlug","hat geschlagen"), // page 3
            Verb("schließen","schloss","hat geschlossen"),
            Verb("beschließen","beschloss","hat beschlossen"),
            Verb("schmelzen","schmolz","hat/ist geschmolzen"),
            Verb("schneiden","schnitt","hat geschnitten"),
            Verb("schreiben","schrieb","hat geschrieben"),
            Verb("schreien","schrie","hat geschrien"),
            Verb("schwimmen","schwamm","hat/ist geschwommen"),
            Verb("sehen","sah","hat gesehen"),
            Verb("sein","war","ist gewesen"),
            Verb("senden","sandte","hat gesandt"),
            Verb("singen","sang","hat gesungen"),
            Verb("sinken","sank","ist gesunken"),
            Verb("sitzen","saß","hat gesessen"),
            Verb("sprechen","sprach","hat gesprochen"),
            Verb("springen","sprang","ist gesprungen"),
            Verb("stechen","stach","hat gestochen"),
            Verb("stehen","stand","hat gestanden"),
            Verb("entstehen","entstand","ist entstanden"),
            Verb("stehlen","stahl","hat gestohlen"),
            Verb("steigen","stieg","ist gestiegen"),
            Verb("sterben","starb","hat/ist gestorben"),
            Verb("stoßen","stieß","hat/ist gestoßen"),
            Verb("streichen","strich","hat gestrichen"),
            Verb("streiten","stritt","hat gestritten"),
            Verb("tragen","trug","hat getragen"),
            Verb("treffen","traf","hat getroffen"),
            Verb("treiben","trieb","hat getrieben"),
            Verb("treten","trat","hat/ist getreten"), // page 4
            Verb("trinken","trank","hat getrunken"),
            Verb("sich betrinken","betrank sich","hat sich betrunken"),
            Verb("tun","tat","hat getan"),
            Verb("vergessen","vergaß","hat vergessen"),
            Verb("verlieren","verlor","hat verloren"),
            Verb("verzeihen","verhieh","hat verziehen"),
            Verb("wachsen","wuchs","ist gewachsen"),
            Verb("waschen","wusch","hat gewaschen"),
            Verb("werden","wurde","ist geworden"),
            Verb("werfen","warf","hat geworfen"),
            Verb("wiegen","wog","hat gewogen"),
            Verb("wissen","wusste","hat gewust"),
            Verb("ziehen","zog","hat/ist gezogen"),
            Verb("beziehen","bezog","hat bezogen"),
            Verb("erziehen","erzog","hat erzogen"),
            Verb("zwingen", "zwang", "hat gezwungen")
    )

    fun getVerb(): Verb{

            val randomNum = rand(0, verbs.size)
            return verbs[randomNum]
    }

    lateinit var foundVerb: Verb


    fun checkVerb(first: TextField?, second: TextField?, third: TextField?, right: String?) {

        for(i in 0..(verbs.size - 1)){
             when (right) {
                verbs[i].pres -> {
                    foundVerb = verbs[i]
                }
                verbs[i].pret -> {
                    foundVerb = verbs[i]
                }
                verbs[i].part2 -> {
                    foundVerb = verbs[i]
                }
            }

        }
        //println("found verb ${foundVerb.part2} and the text is ${third?.text}")
        var hasMistake = false
        if(first?.text == foundVerb.pres){
            first.background = Color.GREEN
        }
        else {
            hasMistake = true
            first?.background = Color.RED
        }

        if(second?.text == foundVerb.pret){
            second.background = Color.GREEN
        }
        else {
            hasMistake = true
            second?.background = Color.RED
        }

        if(third?.text == foundVerb.part2){
            third.background = Color.GREEN
        }
        else {
            hasMistake = true
            third?.background = Color.RED
        }

        if(hasMistake){
            mistakes.add(foundVerb)
            hasMistake = false
        }

    }
}

