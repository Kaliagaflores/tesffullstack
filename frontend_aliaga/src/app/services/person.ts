import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  api="http://localhost:8080/api/person";

  constructor(private http:HttpClient) { }

  getPersons(){
    return this.http.get(this.api);
  }

   getPersonById(id:number){
    return this.http.get(this.api+"/"+id);
  }


  createPerson(data:any){
    return this.http.post(this.api,data);
  }

  deletePerson(id:number){
    return this.http.delete(this.api+"/"+id);
  }

  updatePerson(id:number,data:any){
    return this.http.put(this.api+"/"+id,data);
  }

}