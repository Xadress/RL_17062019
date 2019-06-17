import { FormGroup, FormBuilder } from "@angular/forms";

export abstract class BaseForm{

    protected fb : FormBuilder = new FormBuilder();
    protected form : FormGroup;
    
    isValid(): boolean {
        return this.form!=null && this.form.valid;
    }

    get Form(){
        return this.form;
    }
}