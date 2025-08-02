create table if not exists users (
  id uuid primary key,
  username varchar(64) unique not null,
  created_at timestamp not null default now()
);

create table if not exists exercises (
  id uuid primary key,
  name varchar(128) not null,
  muscle_group varchar(64) not null,
  created_by uuid
);

create table if not exists workouts (
  id uuid primary key,
  user_id uuid,
  name varchar(128) not null,
  notes text,
  created_at timestamp not null default now()
);

create table if not exists workout_exercises (
  workout_id uuid,
  exercise_id uuid,
  position int not null,
  primary key (workout_id, exercise_id)
);

create table if not exists sessions (
  id uuid primary key,
  user_id uuid not null,
  workout_id uuid,
  session_date date not null,
  notes text
);

create table if not exists sets (
  id uuid primary key,
  session_id uuid not null,
  exercise_id uuid not null,
  set_index int not null,
  reps int not null,
  weight_kg numeric(6,2) not null,
  rpe numeric(3,1),
  is_pr boolean default false
);

create index if not exists idx_sets_session on sets(session_id);
