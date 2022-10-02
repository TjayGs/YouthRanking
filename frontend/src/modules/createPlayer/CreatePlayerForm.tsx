import { FC } from "react";

export const CreatePlayerForm: FC = () => {
    return (
                <div className="middle-tile">
                    <div className="field has-text-centered">
                        <h1 className="title">Erstelle Spieler</h1>
                    </div>
                    <div className="columns is-centered">
                        <div className="column is-6">
                            <form className="box">
                                <div className="field">
                                    <label className="label">Vorname</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Vorname" />
                                    </div>
                                </div>
                                <div className="field">
                                    <label className="label">Nachname</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Nachname" required />
                                    </div>
                                </div>
                                <div className="field has-text-centered">
                                    <button className="button is-success">
                                        Erstellen
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
    );
}