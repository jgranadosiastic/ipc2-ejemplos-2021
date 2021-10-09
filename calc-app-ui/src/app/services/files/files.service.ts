import { Historial } from "./../../../objects/calculator/Historial";
import { OperationResponse } from "./../../../objects/calculator/OperationResponse";
import { Operation } from "../../../objects/calculator/Operation";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: "root",
})
export class FilesService {
    readonly API_URL =
        "http://localhost:8081/calc-app-api/files/upload-servlet";

    readonly DOWNLOAD_FILE_URL =
        "http://localhost:8081/calc-app-api/files/download-servlet";

    constructor(private httpClient: HttpClient) {}

    public fileUpload(fileToUpload: File): Observable<void> {
        const formData: FormData = new FormData();

        formData.append("datafile", fileToUpload, fileToUpload.name);

        return this.httpClient.post<void>(this.API_URL, formData);
    }

    public downloadFile(): string {
        return this.DOWNLOAD_FILE_URL;
    }

    public downloadImage(): string {
        return this.DOWNLOAD_FILE_URL + "?image=1";
    }
}
