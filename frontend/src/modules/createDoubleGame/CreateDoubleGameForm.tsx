import {FC, useState} from "react";
import { createDoubleGame } from "../../api/youth-intake.api";
import {handleFormSubmit} from "../../utils/form.utils";

export const CreateDoubleGameForm: FC = () => {
    const [redTeamPlayerOne, setRedTeamPlayerOne] = useState('');
    const [redTeamPlayerTwo, setRedTeamPlayerTwo] = useState('');
    const [redTeamGoals, setRedTeamGoals] = useState(0);
    const [blueTeamPlayerOne, setBlueTeamPlayerOne] = useState('');
    const [blueTeamPlayerTwo, setBlueTeamPlayerTwo] = useState('');
    const [blueTeamGoals, setBlueTeamGoals] = useState(0);

    return (
            <div className="middle-tile">
                <div className="field has-text-centered">
                    <h1 className="title">Erstelle Doppel</h1>
                </div>
                <div className="columns is-centered">
                    <div className="column is-8">
                        <form className="box" onSubmit={handleFormSubmit}>
                            <div className="columns is-centered">
                                <div className="column is-4">
                                    <div className="field">
                                        <label className="label">Team 1 Spieler 1</label>
                                        <div className="control">
                                            <input type="text" className="input" placeholder="Spieler ID"
                                                onChange={e => setRedTeamPlayerOne(e.target.value)}/>
                                        </div>
                                    </div>
                                </div>
                                <div className="column is-4">
                                    <div className="field">
                                        <label className="label">Team 1 Spieler 2</label>
                                        <div className="control">
                                            <input type="text" className="input" placeholder="Spieler ID"
                                                onChange={e => setRedTeamPlayerTwo(e.target.value)}/>
                                        </div>
                                    </div>
                                </div>
                                <div className="column is-2">
                                    <div className="field">
                                        <label className="label">Tore</label>
                                        <p className="control">
                                            <span className="select">
                                                <select onChange={e => setRedTeamGoals(e.target.value as unknown as number)}>
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
                                            <input type="text" className="input" placeholder="Spieler ID"
                                                onChange={e => setBlueTeamPlayerOne(e.target.value)}/>
                                        </div>
                                    </div>
                                </div>
                                <div className="column is-4">
                                    <div className="field">
                                        <label className="label">Team 2 Spieler 2</label>
                                        <div className="control">
                                            <input type="text" className="input" placeholder="Spieler ID"
                                                onChange={e => setBlueTeamPlayerTwo(e.target.value)}/>
                                        </div>
                                    </div>
                                </div>
                                <div className="column is-2">
                                    <div className="field">
                                        <label className="label">Tore</label>
                                        <p className="control">
                                            <span className="select">
                                                <select onChange={e => setBlueTeamGoals(e.target.value as unknown as number)}>
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
                                <button className="button is-success"
                                    onClick={() => createDoubleGame({
                                        redTeamPlayerIdOne: redTeamPlayerOne,
                                        redTeamPlayerIdTwo: redTeamPlayerTwo,
                                        redTeamGoals: redTeamGoals,
                                        blueTeamPlayerIdOne: blueTeamPlayerOne,
                                        blueTeamPlayerIdTwo: blueTeamPlayerTwo,
                                        blueTeamGoals: blueTeamGoals
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