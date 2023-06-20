import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FizzbuzzService {

  constructor(private http: HttpClient) { }

  getFizzBuzzs() {
    return this.http.get("http://localhost:8080/intraway/api/fizzbuzz");
  }

  fizzbuzz(firstNum: number, secNum: number) {
    this.http.post<any>('http://localhost:8080/intraway/api/fizzbuzz/' + firstNum  + '/' + secNum, {})
    .subscribe(data => {
    });
  }
}
