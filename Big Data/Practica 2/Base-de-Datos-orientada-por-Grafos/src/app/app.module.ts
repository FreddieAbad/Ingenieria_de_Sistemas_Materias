import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { AngularNeo4jService } from './angular-neo4j.service';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private neo4j: AngularNeo4jService) {

  }
  public conexion() {
    const url = 'bolt://localhost:7687';
    const username = 'neo4j';
    const password = 'neo4j';
    const encrypted = true;

    this.neo4j
      .connect(
        url,
        username,
        password,
        encrypted
      )
      .then(driver => {
        if (driver) {
          console.log(`Successfully connected to ${url}`);
        }
      });
  }

  public crearUsuario(usuario1: string, usuario2: string) {
    var query =
      ' CREATE ' +
      '   (' + usuario1 + ':Person{name:' + usuario1 + '}), ' +
      '   (' + usuario2 + ':Person{name:' + usuario2 + '}) ' +
      ' WITH m, b ' +
      ' CREATE (' + usuario1 + ')-[:FriendsWith]->(' + usuario2 + ') ';
    this.neo4j.run(query).then(res => {
      console.log(res);
    });
  }
  public editarUsuario(usuario1: string, usuario2: string) {
    var query = 'MATCH (n:Person {' + usuario1 + ': {' + usuario2 + '}}) RETURN n'
    this.neo4j.run(query).then(res => {
      console.log(res);
    });
  }
  public eliminarUsuario(usuario1: string) {
    var query =
      ' MATCH ('+usuario1+':Person)-[rel:IS_RELATED_TO]->(a)' +
      +'DELETE rel; ';
    this.neo4j.run(query).then(res => {
      console.log(res);
    });
  }

}
