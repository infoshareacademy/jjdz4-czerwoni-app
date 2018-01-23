create table Answer
(
  answerId int auto_increment
    primary key,
  answerName varchar(100) not null,
  relatedQuest int not null
)
;

create index Answer_Question_questionId_fk
  on Answer (relatedQuest)
;

create table Category
(
  categoryId int auto_increment
    primary key,
  categoryParent int null,
  categoryPostion int null,
  categoryVisible tinyint(1) default '1' null,
  categoryName varchar(100) not null,
  categoryRelatedQuestId int null,
  categoryAnswerId int null,
  categoryAllegroLink varchar(100) null,
  constraint RelatedAnswerId_fk
  foreign key (categoryAnswerId) references Answer (answerId)
)
;

create index RelatedAnswerId_fk
  on Category (categoryAnswerId)
;

create index RelatedQuestionId_fk
  on Category (categoryRelatedQuestId)
;

create table Question
(
  questionId int auto_increment
    primary key,
  questionName varchar(100) not null
)
;

alter table Answer
  add constraint Answer_Question_questionId_fk
foreign key (relatedQuest) references Question (questionId)
;

alter table Category
  add constraint RelatedQuestionId_fk
foreign key (categoryRelatedQuestId) references Question (questionId)
;

