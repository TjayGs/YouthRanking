import {FC, useState} from "react";
import {createPlayer} from "../../api/youth-intake.api";
import {handleFormSubmit} from "../../utils/form.utils";

export const CreatePlayerForm: FC = () => {
    const [foreName, setForeName] = useState('')
    const [surName, setSurName] = useState('')
    return (
        <div className="middle-tile">
            <div className="field has-text-centered">
                <h1 className="title">Erstelle Spieler</h1>
            </div>
            <div className="columns is-centered">
                <div className="column is-6">
                    <form className="box" onSubmit={handleFormSubmit}>
                        <div className="field">
                            <label className="label">Vorname</label>
                            <div className="control">
                                <input type="text" className="input" placeholder="Vorname" required
                                       onChange={e => setForeName(e.target.value)}/>
                            </div>
                        </div>
                        <div className="field">
                            <label className="label">Nachname</label>
                            <div className="control">
                                <input type="text" className="input" placeholder="Nachname" required
                                       onChange={e => setSurName(e.target.value)}/>
                            </div>
                        </div>
                        <div className="field has-text-centered">
                            <button className="button is-success"
                                    onClick={() => createPlayer({foreName: foreName, surName: surName})}>
                                Erstellen
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}