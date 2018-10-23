/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { RoleUpdateComponent } from 'app/entities/microservice1/role/role-update.component';
import { RoleService } from 'app/entities/microservice1/role/role.service';
import { Role } from 'app/shared/model/microservice1/role.model';

describe('Component Tests', () => {
    describe('Role Management Update Component', () => {
        let comp: RoleUpdateComponent;
        let fixture: ComponentFixture<RoleUpdateComponent>;
        let service: RoleService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [RoleUpdateComponent]
            })
                .overrideTemplate(RoleUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(RoleUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RoleService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Role(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.role = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new Role();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.role = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
