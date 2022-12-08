import {FC} from "react";

export const HelpPage: FC = () => {
    return (
        <div className="conent is-medium">
            <h1 className="title is-1">Youth Rating</h1>
            <i>Youth Rating</i> ist eine Software um eine Kickerrangliste zu erzeugen und einzusehen. Sie basiert auf
            den Entitäten <i>Spieler</i>, <i>Einzelspiele</i> und <i>Doppelspiele</i>.
            Aus diesen Entäten werden Statistiken erzeugt, welche in <i>Youth Rating</i> einsehbar sind.
            <hr/>
            <h1 className="title is-1"> Das Konzept </h1>

            In <i>Youth Rating</i> lassen sich Einzelspiele, als auch Doppelspiele erstellen. Um solch ein Spiel zu
            erstellen, muss man vorher Spieler erstellt haben, welche dann auswählbar sind, wenn man ein Einzelspiel oder ein
            Doppelspiel erstellt. Das Auswählen passiert momentan nur dadurch, dass man die genaue ID des Spieler eintippt.

            Aus diesen Daten werden <a href="#Statistken">Statistiken</a> erzeugt.

            <h3 className="title is-3">Spieler</h3>
            Ein Spieler existiert aus einem Vorname und Nachname. Keines dieser Eigenschaften darf leer sein. Die Kombination beider Werte muss
            einzigartig sein.

            <h3 className="title is-3"> Einzel- und Doppelspiel </h3>
            <i>Youth Rating</i> erlaubt sowohl Einzelspiele und Doppelspiele. In einem Spiel wird ein Best-of-3 gespielt
            bis 5 Tore, bedeutet das eine Begegnung dann vorrüber ist, wenn der erste Spieler 2 Spiele gewonnen hat.

            <h3 id="Statistiken" className="title is-3"> Statistiken </h3>
            Momentan sind keine Statistken vorhanden

            <hr/>
            <h1 className="title is-1"> Zukünftige Änderungen / Ideen </h1>

            <h3 className="title is-3"> Verschiedene Spielmodi </h3>
            Momentan unterstützt die Software nur das Format Best-of-3 unterstützt. Später wir wollen eventuell
            Best-of-5 oder Best-of-1 bis 7 unterstützen

            <h3 className="title is-3"> Statistik-Ideen </h3>
            <h3 className="title is-3"> Rekorde </h3>
            <h3 className="title is-3"> Vereine </h3>
        </div>
    );
}