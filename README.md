# Kiosk-App

This is an appliation created for my SENG 102 final project.  It is a concept application with features expected out of a grocery store self-checkout application.

Features:
* Login Page with login (username and password)
*	Items are loaded from a csv file called ItemList.csv containing barcode, item, price, and department.
*	Search for items in store and view those items in a table (double clicking / tapping search bar).
*	View all items in store in a table (empty search bar, double clicking / tapping search bar).
*	Add items to a cart based on quantity.
*	Change quantity of items in cart
*	Contains a number pad that works with changing quantity of items in cart or for searching in search bar (barcode, price, name)
*	View general information about items in cart like price, name, quantity, and total price of items (price * quantity)
*	View sub-total, tax total, and grand total in a bar below cart.
*	Tax calculations based on the department the items are in (items of miscellaneous department are taxed with Michigan sales tax (6%).
*	Removing items from cart (double clicking the remove text in the row of the item)
*	Request assistance buttons on cart page and checkout page that sends a text message to whomever wants to be contacted for getting assistance (my number is in there, utilizing Vonage API)
*	A cancel order button allows a user to cancel an order at any time on the cart page.
*	On the cart page, there is a checkout button which pulls up a payment page with various payment options (Cash, Debit, Credit, Check, EBT, and NFC (gives companies the choice of implementing payment devices of choice))
*	Users get the option of getting receipts (stored in the receipts folder with “Receipt”+”(hh.mm.ss-MM-DD-YYYY)” as the title.
*	The receipts generated sort the items based on department, and provide the barcode, name, price, and quantity of each item, the form of payment, date and time of order, total items, sub-total, tax, and grand total in a txt file. 
