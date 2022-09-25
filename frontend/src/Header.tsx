export function HeaderComponent() {
    return (
        <nav className='navbar' role={'navigation'} aria-label='main navigation'>
        <div className='navbar-brand'>
          <a className="navbar-item" href="/"> YouthIntake</a>

          {/* TODO for what ? */}
          <a role="button" className="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        <div id="navbar-main" className="navbar-menu">
          <div className="navbar-start">
            <a className="navbar-item">
              Erstelle Spieler
            </a>

            <a className="navbar-item">
              Erstelle Einzel
            </a>

            <a className='navbar-item'>
              Erstelle Doppel
            </a>
          </div>
        </div>
        <div className="navbar-end">
        </div>
      </nav >
    )
}