import { FC } from "react";

export const CreateSingleGameForm: FC = () => {
    return (
        <div className="middle-tile">
            <div className="field has-text-centered">
                <h1 className="title">Erstelle Einzel</h1>
            </div>
            <div className="columns is-centered">
                <div className="column is-8">
                    <form className="box">
                        <div className="columns is-centered">
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Spieler 1</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler 1" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Tore" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="columns is-centered">
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Spieler 2</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler 1" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Tore" />
                                    </div>
                                </div>
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