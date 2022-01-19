/** @format */

import { Component, OnInit } from "@angular/core";
import { FormControl, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Book } from "../book.model";
import { BookService } from "../book.service";

@Component({
  selector: "app-book-create",
  templateUrl: "./book-create.component.html",
  styleUrls: ["./book-create.component.css"],
})
export class BookCreateComponent implements OnInit {
  id_cat: String = "";

  book: Book = {
    id: "",
    title: "",
    author_name: "",
    text: "",
  };

  title = new FormControl("", [Validators.minLength(3)]);
  author_name = new FormControl("", [Validators.minLength(3)]);
  text = new FormControl("", [Validators.minLength(3)]);

  constructor(
    private service: BookService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get("id_cat")!;
  }

  create(): void {
    this.service.create(this.book, this.id_cat).subscribe(
      (resp) => {
        this.router.navigate([`categories/${this.id_cat}/books`]);
        this.service.message("Book created successfully!");
      },
      (err) => {
        this.router.navigate([`categories/${this.id_cat}/books`]);
        this.service.message("Error to create a new book. Try later!");
      }
    );
  }

  cancel(): void {
    this.router.navigate([`categories/${this.id_cat}/books`]);
  }

  getMessage() {
    if (this.title.invalid) {
      return "Title must have minimium 3 and max 100 characters";
    }
    if (this.author_name.invalid) {
      return "Author name must have minimium 3 and max 100 characters";
    }
    if (this.text.invalid) {
      return "Text must have minimium 3 and max 2.000000 characters";
    }
    return false;
  }
}
