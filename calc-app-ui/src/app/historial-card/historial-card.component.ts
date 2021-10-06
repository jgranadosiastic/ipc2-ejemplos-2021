import { Historial } from './../../objects/calculator/Historial';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-historial-card',
  templateUrl: './historial-card.component.html',
  styleUrls: ['./historial-card.component.css']
})
export class HistorialCardComponent implements OnInit {

  @Input() historial!: Historial;

  constructor() { }

  ngOnInit(): void {
  }

}
