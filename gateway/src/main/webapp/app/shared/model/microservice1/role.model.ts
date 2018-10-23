export interface IRole {
    id?: number;
    roleName?: string;
}

export class Role implements IRole {
    constructor(public id?: number, public roleName?: string) {}
}
