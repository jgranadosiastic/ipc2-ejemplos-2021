export class OperationResponse {

    id: Number;
    result: String;

    constructor (id: Number, result: String) {
        this.id = id;
        this.result = result;
    }

    get getId() {
        return this.id;
    }

    get getResult() {
        return this.result;
    }

}