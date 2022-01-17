import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../category.models';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  category: Category = {
    name: '',
    description: ''
  }

  constructor(private service: CategoryService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    this.service.create(this.category).subscribe((response) => {
      this.router.navigate(['categories'])
      this.service.message('Category created successfully!')
    }, err => {
      for (let i = 0; i < err.error.erros.length; i++) {
        this.service.message( err.error.erros[i].message)
      }
    })
  }

  cancel(): void{
    this.router.navigate(['categories'])
  }
}
