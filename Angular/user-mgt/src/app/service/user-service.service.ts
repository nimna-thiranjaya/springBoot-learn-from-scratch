import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  constructor(private httpClient: HttpClient) {}

  baseUrl = 'http://localhost:8090/api/v1';

  requestHeaders = new HttpHeaders({
    'No-Auth': 'True',
  });

  public login(data: any) {
    return this.httpClient.post(this.baseUrl + '/auth/login', data, {
      headers: this.requestHeaders,
    });
  }
}
