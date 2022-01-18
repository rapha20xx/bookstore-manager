import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Book } from "../book.model";
import { BookService } from "../book.service";

@Component({
  selector: "app-book-read",
  templateUrl: "./book-read.component.html",
  styleUrls: ["./book-read.component.css"],
})
export class BookReadComponent implements OnInit {

  displayedColumns: string[] = ["id", "title", "books", "actions"];

  id_cat: String = "";

  books: Book[] = [];

  constructor(private service: BookService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.id_cat = this.route.snapshot.paramMap.get('id_cat')!;
    this.findAll()
  }

  findAll() {
    this.service.findAllCategory(this.id_cat).subscribe((resp) => {
      this.books = resp;
      console.log(this.books);
    });
  }
}
