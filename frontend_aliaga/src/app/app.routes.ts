import { Routes } from '@angular/router';
import { Personas } from './personas/personas';
import { EditarPersona } from './editar-persona/editar-persona';

export const routes: Routes = [

  {
    path: '',
    component: Personas
  },

  {
    path: 'create',
    component: EditarPersona
  },

  {
    path: 'edit/:id',
    component: EditarPersona
  }
];
