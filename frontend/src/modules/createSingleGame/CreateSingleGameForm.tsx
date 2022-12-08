import {FC, useState} from "react";
import {createSingleGame} from "../../api/youth-intake.api";
import {handleFormSubmit} from "../../utils/form.utils";

export const CreateSingleGameForm: FC = () => {
    const [redPlayerId, setRedPlayerId] = useState('');
    const [redGoals, setRedGoals] = useState(0);
    const [bluePlayerId, setBluePlayerId] = useState('');
    const [blueGoals, setBlueGoals] = useState(0);
    return (
        <div className="middle-tile">
            <div className="field has-text-centered">
                <h1 className="title">Erstelle Einzel</h1>
            </div>
            <div className="columns is-centered">
                <div className="column is-6">
                    <form className="box" onSubmit={handleFormSubmit}>
                        <div className="columns is-centered">
                            <div className="column is-4">
                                <div className="field">
                                    <label className="label">Spieler 1</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler ID"
                                               onChange={e => setRedPlayerId(e.target.value)}/>
                                    </div>
                                </div>
                            </div>
                            <div className="column is-2">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <p className="control">
                                        <span className="select">
                                            <select onChange={e => setRedGoals(e.target.value as unknown as number)}>
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
                                    <label className="label">Spieler 2</label>
                                    <div className="control">
                                        <input type="text" className="input" placeholder="Spieler ID"
                                               onChange={e => setBluePlayerId(e.target.value)}/>
                                    </div>
                                </div>
                            </div>
                            <div className="column is-2">
                                <div className="field">
                                    <label className="label">Tore</label>
                                    <p className="control">
                                        <span className="select">
                                            <select onChange={e => setBlueGoals(e.target.value as unknown as number)}>
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
                            <button className="button is-success" onClick={() => createSingleGame({
                                redTeamPlayerId: redPlayerId,
                                redTeamGoals: redGoals,
                                blueTeamPlayerId: bluePlayerId,
                                blueTeamGoals: blueGoals
                            })}>
                                Erstellen
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}