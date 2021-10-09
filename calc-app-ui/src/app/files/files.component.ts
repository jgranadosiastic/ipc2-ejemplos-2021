import { FilesService } from './../services/files/files.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.css'],
})
export class FilesComponent implements OnInit {
  selectedFile: File | null = null;
  fileUploaded: boolean = false;
  messageUpload: String = '';
  downloadUrl: String;
  imageUrl: String;
  showImage: boolean = false;

  constructor(private filesService: FilesService) {
    this.downloadUrl = filesService.downloadFile();
    this.imageUrl = filesService.downloadImage();
  }

  ngOnInit(): void {}

  fileUploadInAngular(event: Event) {
    const files = (event.target as  HTMLInputElement).files;
    if (files != null) {
      this.selectedFile = files.item(0);
    }
  }

  uploadFileToServer() {
    if (this.selectedFile != null) {
      this.filesService.fileUpload(this.selectedFile).subscribe(
        (data) => {
          this.fileUploaded = true;
          this.messageUpload =
            'File ' + this.selectedFile?.name + ' uploaded correctly';
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
