import { FC } from "react";

export const CreateDoubleGameForm: FC = () => {
    return (
        <div className="middle-tile">
            <div className="field has-text-centered">
                <h1 className="title">Erstelle Doppel</h1>
            </div>
            <div className="columns is-centered">
                <div className="column is-8">
                    <form className="box">
                        <div className="columns is-centered">
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Team 1 Spieler 1</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Team 1 Spieler 2</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-2">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <p className="control">
                                        <span className="select">
                                            <select>
                                                <option selected>0</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                            </select>
                                        </span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div className="columns is-centered">
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Team 2 Spieler 1 </label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Team 2 Spieler 2</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler" />
                                    </div>
                                </div>
                            </div>
                            <div className="column is-2">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <p className="control">
                                        <span className="select">
                                            <select>
                                                <option selected>0</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                            </select>
                                        </span>
                                    </p>
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