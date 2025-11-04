import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-check-box-example',
  templateUrl: './sandbox02.component.html',
  styleUrls: ['./sandbox02.component.css'],
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule]
})

export class Sandbox02Component implements OnInit {
  myForm!: FormGroup;
  options = [
    { label: 'Option A', value: 'A' },
    { label: 'Option B', value: 'B' },
    { label: 'Option C', value: 'C' },
  ];

  ngOnInit() {
    this.myForm = new FormGroup({
      selectedOption: new FormControl('A'), // Initial value
    });

    this.myForm.get('selectedOption')?.valueChanges.subscribe(selectedValue => {
      console.log('Radio button selection changed to:', selectedValue);
      console.log('Selected Value (JSON):', JSON.stringify(selectedValue));
      console.log('Selected Value label:', selectedValue.label);
      // Perform actions based on the new selectedValue
    });
  }
}

/*      lotCnt: new FormControl() */