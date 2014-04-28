# SimpleMail

*Authors: Jared Klingenberger (klinge2), Shi Zheng (shiz)*

SimpleMail is an extremely basic email client written in Java. Functionality includes sending mail via SMTP, and receiving, and viewing emails from POP3 mail servers.

## Functionality

### Email messaging via SMTP

The obvious goal of this project is to mimic functionality seen in more sophistocated email clients such as Thunderbird or Outlook. SimpleMail contains a class, `EmailHandler`, which takes a parameter of type `Email` and sends it via a preconfigured SMTP server. Users can either compose a new blank message via the drop-down menu, or users can double-click a contact to draft a message to that contact.

### Basic drafting abilities

Some rudimentary drafting functionality has been implemented in SimpleMail. When composing a message, users can hit "Save as draft" to save a message for later. Drafts are persistent between program reloads. A user can load a previously saved draft via the Drafts tab.

### Configuration state saving

The state of the program is automatically saved on program shutdown. When the program exits, all configuration data, contacts, and drafts are serialized and saved to disk. Configuration is only loaded and stored on startup and shutdown, respectively.

#### It's secure

Since the `Configuration` class that becomes saved to disk can contain sensitive information such as passwords, SimpleMail encrypts the serialized `Configuration` object before writing it to disk. A private key is generated and stored to disk as well. On program reload, the private key is read in and the encrypted Configuration object is decrypted and restored.

### POP mail API

This feature did not get completed, but the funtionality is left available for future modification. If a POP server and authentication information are added to the Configuration dialog, programmers can retrieve unread mail from a POP server by calling `EmailUtility.readMail()`.

### Contact adding, modification, and removal

Users can add, modify, or remove contacts using the buttons at the bottom of the Contacts tab. A user must be selected to use either the modify or remove buttons.

### About SimpleMail dialog

A dialog is available in the Help menu which gives a brief synopsis of SimpleMail and lists the authors.

## Future work/unimplemented functionality

### POP inbox

Development on SimpleMail is leading towards a POP inbox which can read email from an email server. This is useful for obvious reasons, but is beyond the time budget allowed by the assignment. Basic proof-of-concept functionality is left as an artifact in the source code.

### More advanced drafting abilities

The current drafting functionality is very basic. Possible future work in this area would include automatic draft saving when an `EmailTransmissionDlg` closes, and draft deletion upon successful send.

## Who did what?

### Shi Zheng

* `ContactTable` implementation along with `ContactTableModel`
* GUI organization beautification with icons
* Double-click functionality on `ContactTable`
* User-friendly features such as confirmation dialogs
* Contact editing dialog and functionality
* About dialog
* `Contact` class implementation
* `SelectionChangedListener`

### Jared Klingenberger

* `Configuration` class with appropriate getters and setters
* `ConfigurationDlg` design and functionality
* `AbstractDlg` and Abstract control classes for code reuse and common functionality
* Mediator pattern applied to Swing components
* `DataStore` class with `Configuration`, `Contact`, and `Draft` loading and storage
  * Encryption ability for serialized objects
* `Email`, `Draft`, and `EmailHandler` classes
* `AuthenticationInfo` class for storing a username and password

## Issues encountered

### How to handle table updating on the `MainFrame` from other dialogs

This issue came up rather late in development. We figured that our Mediator pattern would be sufficient to handle anything GUI-related. The contact adding/modification/removal feature posed a problem where we had to work out the best, most logical way to get a handle on which contact was being modified, and where in the table to insert the contact.

This problem was difficult because it seemed to break the idea of each of our mediators being confined to single dialogs and not reaching outside the dialogs. Additionally, since both Add and Edit open the same dialog, we had to provide a way for the dialog to understand whether it was adding a contact or editing the selected contact.

Ultimately, we resolved this problem by passing a reference to the table being edited, along with a `boolean` flag which indicated whether or not the dialog should modify an existing user or add a new user. If a modification is occuring, the dialog retrieves the selected table row. The dialog saves the table reference and the selected row index as protected members. The Mediator accesses these members to make the appropriate decision (add or modify).

### Way too many files!

Initially, we kept all our files in a single package and continued development. Over time, the number of classes that made up our program grew excessively large, to the point of being disorganized. We resolved this problem by grouping classes into subpackages. All dialogs go into the `edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.dlg` package in their own subpackages, and abstract dialog and control classes go in the root of that package. MainFrame earned its own package as well, `edu.clemson.cs.cpsc215.klinge2_shiz.assignment3.mainframe` since it didn't make sense to group it under the Dialogs. All of this reorganization made our package structure much easier to understand.

### How to get a persistent horizontal scrollbar

Trying to add a horizontal scrollbar ended up being more work than one would predict. When a horizontal scrollbar was added, the table would resize to accomodate for the scrollbar being present, and then the scrollbar would disappear. Eventually we found the enums `JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS` and `JScrollPane.VERTICAL_SCROLLBAR_ALWAYS` and passed those values to the `JScrollPane` constructor.

## Extra credit features

The descriptions for these features can be found in the [Functionality](#functionality) section.

* [Serialized object encryption](#its-secure)
* [Initial POP support](#pop-mail-api)
* [Drafting abilities](#basic-drafting-abilities)

## Additional thoughts

Overall, this assignment proved interesting to complete. Particularly remarkable was how useful the Mediator pattern came to be in handling Swing events. Additionally, other design patterns were useful -- we found a use for the Singleton pattern, Decorator pattern, Factory pattern, and Template method pattern, if not more. We found the Configuration class to be nice to use since it allowed for any class or dialog to have access to a common dataset.
