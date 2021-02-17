import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { Modalidades } from './modalidades';
import { ModalidadesService } from './modalidades.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }

    modalidades: Modalidades[] = []
    form: FormGroup = new FormGroup({
    cliente : new FormControl('Java', Validators.required)
    })
    
    form2: FormGroup = new FormGroup({
    cpf : new FormControl('', [Validators.required, Validators.maxLength(11), Validators.minLength(11)])
    })

    form3: FormGroup = new FormGroup({
      idade : new FormControl('', Validators.required)
      })
  
    form4: FormGroup = new FormGroup({
      uf : new FormControl('', Validators.required)
      })  
    
    form5: FormGroup = new FormGroup({
      salario : new FormControl('', Validators.required)
    })  

    constructor(
      private service: ModalidadesService
    ){}

      ngOnInit(){
        this.service.listar().subscribe(modalidadesList => this.modalidades = modalidadesList)
      }

    submit(){
      
      const modalidades: Modalidades = { ...this.form.value }
      this.service
        .salvar(modalidades)
        .subscribe(savedModalidades => {
          this.modalidades.push(savedModalidades)
          this.form.reset()  
          })
        }

    submit2(){
      console.log(this.form.value)
    }

}
