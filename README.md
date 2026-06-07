<div align="center">

# Nota

**A clean, modular notes app built with Kotlin Multiplatform & Compose Multiplatform — one shared codebase for Android and iOS.**

![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin_Multiplatform-7F52FF?style=flat&logo=kotlin&logoColor=white)
![Compose Multiplatform](https://img.shields.io/badge/Compose_Multiplatform-4285F4?style=flat&logo=jetpackcompose&logoColor=white)
![SQLDelight](https://img.shields.io/badge/SQLDelight-003B57?style=flat&logo=sqlite&logoColor=white)
![Koin](https://img.shields.io/badge/Koin_DI-EA8C00?style=flat)
![Platform](https://img.shields.io/badge/Android_·_iOS-555?style=flat)

</div>

---

**Nota** is a notes app that demonstrates a production-style **Kotlin Multiplatform** architecture: a single shared core for domain, data, and UI, rendered with **Compose Multiplatform** on both Android and iOS. State, persistence, and dependency injection all live once in `commonMain`.

## ✨ Features

- **Shared UI** with Compose Multiplatform — one screen layer for Android and iOS.
- **Local persistence** via SQLDelight (type-safe SQL, multiplatform drivers).
- **Dependency injection** with Koin, including Compose ViewModel integration.
- **Reactive state** via Kotlin coroutines & Flow, with lifecycle-aware ViewModels.
- **Strict modularization** — clear boundaries between domain, database, UI, and feature.

## 🛠 Tech stack

| Layer | Technologies |
|---|---|
| UI | Compose Multiplatform · Navigation Compose |
| State / DI | Coroutines + Flow · Koin (core / compose / viewmodel) |
| Persistence | SQLDelight (android + native drivers) |
| Targets | Android · iOS |

## 🏗 Modules

```
Nota/
├── core/
│   ├── domain/      # models + business logic (pure Kotlin)
│   ├── database/    # SQLDelight schema + queries
│   └── ui/          # shared Compose design system
├── feature/
│   └── notes/       # notes feature: screens, state, wiring
├── androidApp/      # Android entry point
└── iosApp/          # iOS entry point (SwiftUI host)
```

## 🗺️ How it fits together

```mermaid
flowchart TD
  AND["🤖 androidApp"]
  IOS["🍎 iosApp"]
  UI["🎨 core:ui · Compose MP"]
  FEAT["📝 feature:notes"]
  DOM["🧠 core:domain"]
  DB["💾 core:database · SQLDelight"]
  AND --> UI
  IOS --> UI
  UI --> FEAT
  FEAT --> DOM
  FEAT --> DB
  DB --> DOM
```

## 📸 Screenshots

> _Captures coming soon — drop them in `docs/screenshots/` and they'll render here._

| List | Editor | iOS |
|:---:|:---:|:---:|
| – | – | – |

## 🚀 Getting started

```bash
# Android
./gradlew :androidApp:installDebug

# iOS — open iosApp/ in Xcode and run (Kotlin framework builds via Gradle)
```

---

<div align="center"><sub>Built by <b>Ahmed Essam</b> · <a href="mailto:ahmedessamedeen@gmail.com">ahmedessamedeen@gmail.com</a> · <a href="https://github.com/ahmedessameldeen">@ahmedessameldeen</a></sub></div>
