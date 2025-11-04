import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CannedFruit } from './cannedFruit';
import { Medium } from './medium';
import { catchError, Observable } from 'rxjs';
import { AbbrevCannedFruit } from './abbrevCannedFruit';

@Injectable({
  providedIn: 'root'
})
export class CannedFruitService {

  constructor(private http: HttpClient) { }
  cannedFruits: CannedFruit[] = [];

  handleNull(medium: Medium): string {
    let mediumName: string = '--No Medium--';
    if (medium !== null) {
      mediumName = medium.mediumName;
    }
    return mediumName;
  }
  getOneCannedFruit(id: number) {
    return this.http.get<CannedFruit>('http://localhost:8081/api2/cannedFruit/' + id);
  }
  getCannedFruitsByIdList(ids: number[]): Observable<CannedFruit[]> {
    let namedParams = this.arrayToNamedParams(ids);
    return this.http.get<CannedFruit[]>('http://localhost:8081/api2/cannedFruitIdCollection' + namedParams, { withCredentials: true });
  }

  getCannedFruits() {
    return this.http.get<CannedFruit[]>('http://localhost:8081/api2/cannedFruit');
  }
  getCannedFruitsByFruit(fruit: string) {
    return this.http.get<CannedFruit[]>('http://localhost:8081/api2/cannedFruit?fruit=' + fruit);
  }
  getCannedFruitsNoOrders(fruit: string) {
    return this.http.get<AbbrevCannedFruit[]>('http://localhost:8081/api2/cannedFruitNoOrders?fruit=' + fruit);
  }
  genDistinctFruits() {
    console.log("before call: cannedFruitSvc.genDistinctFruits()");
    this.http.get<any>('batch/distinctFruitDoc', { responseType: 'text' as 'json' }).subscribe((response) => {
      console.log("response01: " + JSON.stringify(response));
      console.log("response02: " + response);
    });
  }
  getDistinctFruits() {
    return this.http.get<string[]>('http://localhost:8081/api2/distinctFruits');
  }
  getDistinctFruitsLocal() {
    return this.http.get<string[]>('/assets/distinctFruits.json');
  }
  getMediums() {
    return this.http.get<Medium[]>('./assets/mediums.json');
  }
  getMediums2() {
    return this.http.get<Medium[]>('http://localhost:8081/api2/medium');
  }
  getMediumByName(mediumName: string, mediums: Medium[]) {
    let medium: Medium = new Medium(0, '');
    for (let i = 0; i < mediums.length; i++) {
      if (mediumName === mediums[i].mediumName) {
        medium = mediums[i];
        break;
      }
    }
    return medium;
  }

  addCannedFruit(cannedFruit: CannedFruit) {
    return this.http.post('http://localhost:8081/api2/cannedFruit', cannedFruit);
  }
  updCannedFruit(cannedFruit: CannedFruit) {
    console.log("updCannedFruit: CannedFruit id:" + cannedFruit.id);
    return this.http.put('http://localhost:8081/api2/cannedFruit/' + cannedFruit.id, cannedFruit);
  }
  deleteCannedFruit(id: number) {
    return this.http.delete('http://localhost:8081/api2/cannedFruit/' + id);
  }

  public arrayToNamedParams(ids: number[]): string {
    return '?id=' + [...ids].join('&id=');
  }
}
