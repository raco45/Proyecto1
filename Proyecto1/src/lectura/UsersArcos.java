/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import graforedsocial.Lista;

/**
 *
 * @author raco1
 */
public class UsersArcos {
    private Lista users;
    private Lista arcos;
    
    public UsersArcos(Lista users, Lista arcos){
        this.users=users;
        this.arcos=arcos;
    }

    /**
     * @return the arcos
     */
    public Lista getArcos() {
        return arcos;
    }

    /**
     * @return the users
     */
    public Lista getUsers() {
        return users;
    }

    /**
     * @param arcos the arcos to set
     */
    public void setArcos(Lista arcos) {
        this.arcos = arcos;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Lista users) {
        this.users = users;
    }
}
