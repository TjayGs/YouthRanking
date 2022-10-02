import { FC } from "react";

export const HelpPage: FC = () => {
    return (
        <div className="content is-medium">
            <h1 className="title">Youth Rating</h1>
            <i>Youth Rating</i> ist eine Software welche eine Kickerrangliste erzeugt. Sie dient dazu, eine Rangliste zu erzeugen, um Spieler miteinander
            zu vergleichen, als auch die eigenen Statistiken zu sehen.
            <hr />
            <h1> Das Konzept </h1>

            In <i>Youth Rating</i> lassen sich nochmale Einzelspiele, als auch Doppelspiele erstellen. Darueber hinaus muss man auch Spieler erstellen.
            Das sind die Grunddaten um eine Statistik zu erzeugen. Neben der normalen Anzeige von Siegen und Niederlagen, wird beispielsweise auch eine Elo
            berechnet.

            <h3> Ein Spiel </h3>
            Ein Spiel ist ein Best-Of-1 bis 6. Es gibt kein Unentschieden !

        </div>
    );
}