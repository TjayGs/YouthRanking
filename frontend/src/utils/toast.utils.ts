import { toast } from "react-toastify";
import { getErrorKeyTranslation } from "../constants/errorKeys";

/**
* This function will create an error toast in the top right corner. It will translate the given error key
*/
export function createErrorToastWithErrorKey(errorKey: string) {
    toast.error(getErrorKeyTranslation(errorKey), {
        position: "top-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "colored",
    });
}