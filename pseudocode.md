# Assignment 4 Pseudocode 
## Written by: Gunvir Lubana

### Plot Class - overlaps() method
```
Method overlaps(other plot):
    // basically checking if two rectangles DON'T overlap, then flip the result
    
    // check if one plot is completely to the left of the other
    if this plot's right edge is at or before other plot's left edge:
        return false
    if other plot's right edge is at or before this plot's left edge:
        return false
    
    // check if one plot is completely above/below the other
    if this plot's bottom edge is at or above other plot's top edge:
        return false
    if other plot's bottom edge is at or above this plot's top edge:
        return false
    
    // if we got here, they must overlap somehow
    return true
```

### Plot Class - encompasses() method
```
Method encompasses(other plot):
    // need to check if the other plot fits completely inside this plot
    // edges can touch - that's okay
    
    check if other plot's left edge >= this plot's left edge
    check if other plot's right edge <= this plot's right edge
    check if other plot's top edge >= this plot's top edge
    check if other plot's bottom edge <= this plot's bottom edge
    
    if all four conditions are true:
        return true
    else:
        return false
```

### ManagementCompany Class - addProperty() method
```
Method addProperty(property to add):
    // gotta check a bunch of stuff before we can add it
    
    // first check - is property null?
    if property is null:
        return -2  // error code for null property
    
    // second check - is array full?
    if number of properties >= MAX_PROPERTY (which is 5):
        return -1  // error code for full array
    
    // third check - does the company plot contain this property?
    if company plot does NOT encompass property's plot:
        return -3  // error code for not encompassed
    
    // fourth check - does it overlap with existing properties?
    for each existing property in the array:
        if current property's plot overlaps with new property's plot:
            return -4  // error code for overlap
    
    // if we made it here, we can add the property!
    create a copy of the property (using copy constructor)
    add it to the properties array at index = numberOfProperties
    increment numberOfProperties by 1
    
    return the index where we added it (numberOfProperties - 1)
```

### ManagementCompany Class - getTotalRent() method
```
Method getTotalRent():
    // pretty straightforward - just add up all the rents
    
    set total to 0.0
    
    for i from 0 to numberOfProperties - 1:
        if properties[i] is not null:
            add properties[i]'s rent amount to total
    
    return total
```

### ManagementCompany Class - getHighestRentProperty() method
```
Method getHighestRentProperty():
    // find the property with max rent
    
    if numberOfProperties equals 0:
        return null  // no properties to check
    
    set highestProperty to properties[0]
    set highestRent to properties[0]'s rent amount
    
    for i from 1 to numberOfProperties - 1:
        if properties[i] is not null:
            if properties[i]'s rent > highestRent:
                set highestRent to properties[i]'s rent
                set highestProperty to properties[i]
    
    return highestProperty
```

### ManagementCompany Class - toString() method
```
Method toString():
    // build a string with all the company and property info
    
    start with string: "List of the properties for [company name], taxID: [tax ID]\n"
    add line of underscores: "______________________________________________________\n"
    
    for each property from 0 to numberOfProperties - 1:
        if property is not null:
            add property's toString() + "\n"
    
    add another line of underscores: "______________________________________________________\n"
    
    calculate totalRent using getTotalRent()
    calculate managementFee = totalRent * mgmFee / 100.0
    
    add: "\n total management Fee: " + managementFee
    
    return the complete string
```

### Property Class - Copy Constructor
```
Constructor Property(other property):
    // make a deep copy of another property
    
    copy propertyName from other property
    copy city from other property  
    copy owner from other property
    copy rentAmount from other property
    
    // important: create a NEW plot object, don't just copy the reference
    create new Plot using other property's plot (calls Plot copy constructor)
```

### Main Program Flow
```
When user runs the GUI:
    1. User enters management company info (name, tax ID, fee %)
    2. System creates ManagementCompany object with that info
    3. User can add properties one by one:
        - Enter property details (name, city, rent, owner)
        - Enter plot location and size
        - System tries to add property using addProperty()
        - If successful, property appears on visual plot
        - If error, show appropriate message:
            * "Property plot not encompassed by company plot"
            * "Property plot overlaps another property"
            * "Array is full - can't add more properties"
    4. User can click buttons to:
        - Show highest rent property
        - Calculate total rent
        - List all properties with management fee
    5. System uses toString() and other methods to display results
```