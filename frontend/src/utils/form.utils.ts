import {FormEvent} from "react";

export const handleFormSubmit = (event: FormEvent) => {
    // 👇️ prevent page refresh. It will also enable the create fetch request to the backend
    event.preventDefault();
};