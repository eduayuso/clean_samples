# CleanSamples

[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0) ![kotlin-version](https://img.shields.io/badge/kotlin-1.4.30-orange)

This is a starting point for **Android** projects designed with **Clean Arquitecture**, intended to be understable, testable and scalable. This project is preconfigured with essentials libraries and tools, as well as modules, interfaces, base classes and sample apps, just ready for you to start your Android app.

The project is Gradle optimized, and divided in modules so that each one has only the required dependencies:
* **/apps/** Android apps, only depends on Android SDK and presentation layer.
* **/shared/presentation/** Contains the presenters. Depends on data layer.
* **/shared/data/** Contains the services and data source definitions. Depends on domain layer.
* **/shared/impl/** Contains the implementation of interactors, services and repositories. Depends on data and domains layers and in data access libraries (Retrofit, Ktor, SQLite, ...)
* **/shared/domain/** Contains the data entities and the use cases interfaces. Only has a dependency on kotlin serialization library.

## Apps and architecture used
Each sample app is made with a different architecture:
* [x] /apps/mvpapp: MVP (Model View Presenter)
* [x] /apps/mvvmapp: MVVM (Model View View-model).
* [ ] /apps/mviapp: MVI (Model View Intent)

## Features
* [ ] Login
* [ ] SignUp
* [x] UserList
* [ ] UserDetail
* [x] PostList
* [ ] PostDetail

## Network implementation
* [x] Ktor
* [ ] Retrofit

## Unit Tests
* [ ] AuthenticationUsesCases
* [x] UsersUsesCases
* [ ] PostsUsesCases

## Instrumentation Tests
* [ ] AuthActivity
* [ ] LoginFragment
* [ ] SignUpFragment
* [ ] HomeActivity
* [ ] UserListFragment
* [ ] UserDetailActivity
* [ ] PostListFragment
* [ ] PostDetailActivity

## License

    Copyright 2020 Eduardo Rodriguez Ayuso

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
