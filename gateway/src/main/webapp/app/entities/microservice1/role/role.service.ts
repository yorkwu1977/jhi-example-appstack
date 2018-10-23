import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IRole } from 'app/shared/model/microservice1/role.model';

type EntityResponseType = HttpResponse<IRole>;
type EntityArrayResponseType = HttpResponse<IRole[]>;

@Injectable({ providedIn: 'root' })
export class RoleService {
    private resourceUrl = SERVER_API_URL + 'microservice1/api/roles';

    constructor(private http: HttpClient) {}

    create(role: IRole): Observable<EntityResponseType> {
        return this.http.post<IRole>(this.resourceUrl, role, { observe: 'response' });
    }

    update(role: IRole): Observable<EntityResponseType> {
        return this.http.put<IRole>(this.resourceUrl, role, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IRole>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IRole[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
