import { ChangeDetectorRef, Component } from '@angular/core';
import { PersonService } from '../services/person';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-persona',
  imports: [CommonModule, FormsModule],
  templateUrl: './editar-persona.html',
  styleUrl: './editar-persona.css',
})
export class EditarPersona {
  person: any = {
    nombre: '',
    apellido: '',
    fechaNacimiento: '',
    puesto: '',
    sueldo: null,
  };

  id: number | null = null;

  constructor(
    private personService: PersonService,
    private router: Router,
    private route: ActivatedRoute,
    private cdr: ChangeDetectorRef,
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    console.log('ID:', this.id);

    if (this.id) {
      this.loadPerson();
    }
  }

  loadPerson() {
    if (this.id !== null) {
      this.personService.getPersonById(this.id).subscribe((res: any) => {
        const person = res.data;

        if (person) {
          this.person = person;
          this.cdr.detectChanges(); // fuerza actualización del DOM
          console.log('persona a editar', person);
        }
      });
    }
  }

  save() {
    if (this.id) {
      this.personService.updatePerson(this.id, this.person).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.personService.createPerson(this.person).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancel() {
    this.router.navigate(['/']);
  }
}
