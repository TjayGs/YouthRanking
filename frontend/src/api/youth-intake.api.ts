import {Player} from "../entities";
import {createErrorToastWithErrorKey} from "../utils/toast.utils";
import {GENERIC_ERROR_KEY} from "../constants/errorKeys";

const serverUrl = 'http://localhost:8080'

export async function createPlayer(player: Player) {
    await fetch(serverUrl + '/players', {
        method: 'POST',
        headers: {
            'Accept': '*/*',
            'Content-Type': 'application/json'

        },
        body: JSON.stringify(player)
    })
        .then((response) => {
            response.json()
                .then((json) => {
                    if (!response.ok) {
                        createErrorToastWithErrorKey(json.messageErrorKey ?? GENERIC_ERROR_KEY)
                    } else {
                        console.log("Created player: " + json)
                    }
                })
        })
}