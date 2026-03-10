import { ChangeDetectorRef, Component } from '@angular/core';
import { Router } from '@angular/router';
import { PersonService } from '../services/person';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-personas',
  imports: [CommonModule],
  templateUrl: './personas.html',
  styleUrl: './personas.css',
})
export class Personas {
  persons: any[] = [];

  constructor(
    private personService: PersonService,
    private router: Router,
        private cdr: ChangeDetectorRef,

  ) {}

  ngOnInit(): void {
    this.loadPersons();
  }

  loadPersons() {
    console.log('hola a todos');

    this.personService.getPersons().subscribe((res: any) => {
      this.persons = [...res.data];
          this.cdr.detectChanges(); // fuerza actualización del DOM

      console.log('data', this.persons);
    });
  }

  create() {
    this.router.navigate(['/create']);
  }

  edit(id: number) {
    this.router.navigate(['/edit', id]);
  }

  delete(id: number) {
    if (confirm('¿Desea eliminar esta persona?')) {
      this.personService.deletePerson(id).subscribe(() => {
        this.loadPersons();
      });
    }
  }
}
