export const GENERIC_ERROR_KEY: string = "generic";

const errorKeyMap = new Map<string, string>([
    ["generic", "Es ist ein Fehler aufgetreten"],
    ["0001", "Der Vor- oder Nachname darf nicht leer sein"]
]);

/**
* Function will return the translation for the given errorkey
*/
export function getErrorKeyTranslation(errorKey: string): string {
    return errorKeyMap.get(errorKey) ?? errorKeyMap.get("generic")!;
}