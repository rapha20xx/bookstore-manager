import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Category } from '../category.models';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrls: ['./category-update.component.css']
})
export class CategoryUpdateComponent implements OnInit {

  category: Category = {
    id: '',
    name: '',
    description: ''
  }

  constructor(private service: CategoryService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.category.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById(): void {
    this.service.findById(this.category.id!).subscribe((resp) => {
      this.category.name = resp.name
      this.category.description = resp.description
    })
  }

  update(): void {
    this.service.update(this.category).subscribe((resp) => {
      this.router.navigate(["categories"]);
      this.service.message("Category update successfully!")
    }, err=>{
      this.service.message("Need to be filled!")
    })
  }

  cancel(): void {
    this.router.navigate(["categories"])
  }
}
