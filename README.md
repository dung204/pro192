# PRO192 (Object-oriented programming) Code Tour

_Official repository for source code, documentation, and "tour guide" for PRO192 of [FPT University Hanoi](https://hanoi.fpt.edu.vn/)_

## :no_entry: Disclaimer

> This repository is meant for everyone: teachers who wants to teach using documentation, students who wants to study the code or improving experiences, etc. I don't mean to "leak the answers" to students, or doing any "illegal" acts. I simply wants a better experience for everyone when reading the code

## 1. Directory structure

Each assignment/test folder contains:

```
├── .tours/ (Contains metadata and content for tour guide)
├── lib/ (Contains third-party libraries)
├── src/ (Contains source code)
├── static/ (Contains media files for tour guide)
├── *.pdf (Assignment/test requirements files)
...
```

## 2. Code documentation

- All documentation for each assignments and tests are available at `README.md` file.

> ### ⚠️ Before you use the documentation:
>
> 1. The documentation uses code from the source code files. For a better experience, opening code files and read them along with `README.md` is recommended.
> 2. Some of the content may not be useful for you. Feel free to skip if you want to. In the future, I will add some signs to notify if some parts are important.
> 3. The documentation is composed by [@dung204](https://github.com/dung204/), and open for everyone to use. However, copying or re-uploading are not allowed under any circumstances.

## 3. Tour guide (for [Visual Studio Code](https://code.visualstudio.com/) only)

> ⚡ _Powered by [CodeTour](https://marketplace.visualstudio.com/items?itemName=vsls-contrib.codetour) extension_

### 3.1. Installing VSCode and CodeTour:

- Download and install Visual Studio Code [here](https://code.visualstudio.com/) if you haven't installed.

- Once installed, you can install CodeTour extension inside VSCode:

  - Open VSCode

  - Find and click Extension panel (or `Ctrl+Shift+X`) <img src="./static/extension-panel.png" alt="extension-panel" width="30"></img>

  - You want to find this extension

  ![codetour-extension](./static/codetour-extension.png)

  - Hit "Install" to install the extension

### 3.2. Using CodeTour:

- Click "Explorer" <img src="./static/explorer-panel.png" alt="explorer-panel" width="30"> (or `Ctrl+Shift+E`), you want to find "CodeTour" panel

![codetour-nav-1](./static/codetour-nav-1.png)

- If "CodeTour" panel does not show, make sure the extension is enabled, then in the "Explorer", click the three dots ($\cdots$) and check "CodeTour", like this:

![codetour-nav-2](./static/codetour-nav-2.png)

- Click play button to start the tour for any tour-guide-supported source code.

- A step in the tour guide looks like this:

![codetour-step](./static/codetour-step.png)

- Buttons explained:

  - Click "Previous" or $\leftarrow$ on top right corner to go backward, "Next" or $\rightarrow$ on top right corner to go forward.

  - Click $\square$ to stop the tour

  - Click the pen button on top right corner to edit the step's content (not recommended).

  - Click ⬆️ on top right corner to collapse this panel (not recommended).

- You can also jump to any step you want in the "CodeTour" panel, as long as the tour is running.

![codetour-jump-step](./static/codetour-jump-step.png)

> ⚠️ : The $\uparrow$ and $\downarrow$ are for **moving** steps up/down, **NOT navigating** to previous/next step. Hence, it's not recommended to click these 2 buttons.
