
library("xlsx")
mydata <- read.xlsx("C:/Users/megan/Documents/OS.xlsx", 1)
mydata <- read.xlsx("C:/Users/megan/Documents/OS.xlsx", sheetName = "Times")

summary(mydata)

hist(mydata$FILE_TIME, sub = "Histogram of File Times")
x11()

hist(mydata$FOLDER_TIME, sub = "Histogram of Folders Times")













