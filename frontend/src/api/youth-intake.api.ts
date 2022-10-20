import {Player} from "../entities";

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
        console.log("Created player: " + response.json())
    })
    .catch((error) => {
        console.log(error)
    })
}