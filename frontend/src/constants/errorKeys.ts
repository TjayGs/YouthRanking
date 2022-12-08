export const GENERIC_ERROR_KEY: string = "generic";

const errorKeyMap = new Map<string, string>([
    ["generic", "Es ist ein Fehler aufgetreten"],
    ["0001", "Der Vor- oder Nachname darf nicht leer sein"],
    ["0002", "Es existiert bereits ein Spieler mit dem selben Vor- und Nachname"],
    ["0003", "Die Tore wurden nicht korrekt angegeben"]
]);

/**
* Function will return the translation for the given errorkey
*/
export function getErrorKeyTranslation(errorKey: string): string {  
    return errorKeyMap.get(errorKey) ?? errorKeyMap.get("generic")!;
}