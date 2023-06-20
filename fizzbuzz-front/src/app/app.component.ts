import { Component, OnInit } from '@angular/core';
import  { FizzbuzzService } from './fizzbuzz.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'FizzBuzz-app';

  fizzbuzzs: any;

  firstNum: number;
  secNum: number;

  constructor(private fizzbuzzService: FizzbuzzService) {
    this.firstNum = 0;
    this.secNum = 0;
  }

  ngOnInit() {
    this.fizzbuzzService.getFizzBuzzs()
      .subscribe( result =>  this.fizzbuzzs = result)
  }

  fizzbuzz() {
    this.fizzbuzzService.fizzbuzz(this.firstNum, this.secNum);
    window.location.reload();
  }
}
