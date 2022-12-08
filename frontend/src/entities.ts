export interface Player {
    id?: string; // Could be empty in cases where you want to create a player
    foreName: string;
    surName: string;
}

export interface SingleGame {
    id?: string; // Could be empty in cases where you want to create a singlegame
    redTeamPlayerId: string
    redTeamGoals: number
    blueTeamPlayerId: string
    blueTeamGoals: number
}

export interface DoubleGame {
    id?: string; // Could be empty in cases where you want to create a singlegame
    redTeamPlayerIdOne: string
    redTeamPlayerIdTwo: string
    redTeamGoals: number
    blueTeamPlayerIdOne: string
    blueTeamPlayerIdTwo: string
    blueTeamGoals: number
}